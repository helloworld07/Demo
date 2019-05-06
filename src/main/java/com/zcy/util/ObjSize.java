package com.zcy.util;

import sun.misc.Unsafe;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: George
 * @date: 2019/4/9
 * @description:
 */
public class ObjSize {
    //对象头 8
    public static final int OBJ_BASIC_LEN = 8;
    //指针 64为默认开启压缩，也就是4，不压缩就是8
    public static final int OBJ_REF_LEN = 4;
    //数组长度4
    public static final int ARRAY_BASIC_LEN = 4;
    //reference指针压缩4 不压缩8
    public static final int REF_LEN = 4;

    public static final int ALIGN = 8;

    private static Unsafe u;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            u = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private enum TypeLength {
        布尔(1), 字节(1), 字符(2), 短整(2),
        整形(4), 单精(4), 长整(8), 双精(8);
        private int bt;

        private TypeLength(int bt) {
            this.bt = bt;
        }

        public int getBt() {
            return bt;
        }
    }

    public static int sizeOfObj(Object o) {
        int bt = 0;
        if (o == null) {
            return bt;
        }
        Class initclass = o.getClass();
        Object initO = o;
        if (o.getClass().isArray()) {
            return sizeOfArray(o);
        }
        //用非阻塞队列
        Queue q = new LinkedList();
        q.offer(o.getClass());
        //创建子对象并不会创建父对象，私有属性和构造方法不会被继承
        //但是在计算的时候还是要把他的私有属性带进去
        while (q.size() != 0) {
            Class oz = (Class) q.poll();
            //父类不加头部
            if (oz == initclass)
                bt += OBJ_BASIC_LEN + REF_LEN;//头部12

            Field[] fs = oz.getDeclaredFields();
//		 Class father=clazz.getSuperclass();
//		 Field[] _ffs=father.getDeclaredFields();
//		 List<Field> ffsList=new ArrayList<Field>();
//		 for(int i=0;i<_ffs.length;i++) {
//			 //判断属性是不是私有的，getFields这个方法可以直接过滤掉private，但连protected也会过滤
//			 if(_ffs[i].isAccessible())
//			 ffsList.add(_ffs[i]);
//		 }
//		 Field[] ffs=(Field[]) ffsList.toArray(new Field[ffsList.size()]);
//		 fs=Arrays.copyOf(fs, fs.length+ffs.length);
//		 System.arraycopy(ffs, 0, fs, fs.length-ffs.length, ffs.length);
            if (fs.length != 0) {
                for (Field f : fs) {
                    if (Modifier.isStatic(f.getModifiers()))
                        continue;
                    Class type = f.getType();

                    if (type == boolean.class)
                        bt += TypeLength.布尔.getBt();
                    else if (type == byte.class)
                        bt += TypeLength.字节.getBt();
                    else if (type == char.class)
                        bt += TypeLength.字符.getBt();
                    else if (type == short.class)
                        bt += TypeLength.短整.getBt();
                    else if (type == int.class)
                        bt += TypeLength.整形.getBt();
                    else if (type == float.class)
                        bt += TypeLength.单精.getBt();
                    else if (type == double.class)
                        bt += TypeLength.双精.getBt();
                    else if (type == long.class)
                        bt += TypeLength.长整.getBt();
                    else if (type == void.class) {
                    } else if (type.isArray()) {
                        bt += REF_LEN;//4
                        Object oo = u.getObject(initO, u.objectFieldOffset(f));
                        if (oo != null)
                            bt += sizeOfArray(oo);
                    } else {
                        bt += REF_LEN;//4
                        Object oo = u.getObject(initO, u.objectFieldOffset(f));
                        if (oo != null)
                            bt += sizeOfObj(oo);
                    }
                }
            }

            Class father = oz.getSuperclass();
            if (father != null) {
                q.offer(father);
            }
        }
        if (bt % ALIGN > 0) {
            bt += ALIGN - (bt % ALIGN);
        }
        return bt;
    }

    //数组
    private static int sizeOfArray(Object os) {
        if (os == null) {
            return 0;
        }
        int length = Array.getLength(os);
        int bt = OBJ_BASIC_LEN + OBJ_REF_LEN + ARRAY_BASIC_LEN;//16
        Class type = os.getClass();
        if (type == boolean[].class)
            bt += TypeLength.布尔.getBt() * length;
        else if (type == byte[].class)
            bt += TypeLength.字节.getBt() * length;
        else if (type == char[].class)
            bt += TypeLength.字符.getBt() * length;
        else if (type == short[].class)
            bt += TypeLength.短整.getBt() * length;
        else if (type == int[].class)
            bt += TypeLength.整形.getBt() * length;
        else if (type == float[].class)
            bt += TypeLength.单精.getBt() * length;
        else if (type == double[].class)
            bt += TypeLength.双精.getBt() * length;
        else if (type == long[].class)
            bt += TypeLength.长整.getBt() * length;
        else {
            Object[] uh = new Object[length];
            for (int i = 0; i < length; i++) {
                uh[i] = Array.get(os, i);
            }
            for (Object o : uh) {
                bt += REF_LEN + sizeOfObj(o);
            }
        }
        if (bt % ALIGN > 0) {
            bt += ALIGN - (bt % ALIGN);
        }
        return bt;
    }
}