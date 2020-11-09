package com.zcy.dozer;

import com.zcy.dozer.entity.ContacterDO;
import com.zcy.dozer.entity.ContacterVO;
import org.dozer.DozerBeanMapper;

/**
 * 一种entity复制工具，需要引入maven,可以通过配置复制一个对象的属性值到另一个对象的不同属性上
 * 将ContacterVO中属性值赋值给ContacterDO中相对应字段
 * 若对应字段名称不同时，需要加入配置文件，此例为了说明，也写了
 */
//@Component
public class ContacterController {

//    @Autowired
//    private DozerBeanMapper dozerBeanMapper ;//spring工程调用接口时可使用Autowired方式注解进来直接使用

    public ContacterDO add(ContacterVO contacterVO) {
        System.out.println("添加一个联系人");
        //使用dozer进行转换
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        ContacterDO contacterDO = dozerBeanMapper.map(contacterVO, ContacterDO.class);
        return contacterDO;
    }

    public static void main(String[] args) {
        ContacterController contacterController = new ContacterController();
        ContacterVO contacterVO = new ContacterVO();
        contacterVO.setAge(18);
        contacterVO.setLocation("shanghai");
        contacterVO.setName("george");
        ContacterDO contacterDO = contacterController.add(contacterVO);
        System.out.println(contacterDO.getName());
    }


}
