package com.zcy.funcMethod;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class QueryPojo implements Serializable {
    /**
     * 店铺id
     */
    public Integer shopCode;
    /**
     * 时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss SSS")
    private Date startDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss SSS")
    private Date endDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss SSS")
    private Date exeDate;

    private Integer wareStatus;
    /**
     * 支付宝拉取状态
     */
    private Integer alipayStatus;
    /**
     * 店铺全称
     */
    private String namePlat;
    /**
     * 店铺简称
     */
    private String enName;
    //店铺表查询需要
    /**
     * plat_id :平台id
     */
    private Integer platId;

    /**
     * 2020.4.17覆盖同时多个平台情况
     */
    private List<Integer> platIds;

    /**
     * 需要排除的平台id们2019.11.07（因海外店加入后造成问题而增加）
     */
    private List<Integer> exPlatIds;

    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * parent_id
     */
    private Integer parentId;
    /**
     * ecs，crm系统配置表
     */
    private Integer ecsShangdianId;

    /**
     * ecs数据库库名
     */
    private String ecsRepertoryName;
    /**
     * crm数据库库名
     */
    private String crmRepertoryName;
    /**
     * queryPojo
     * crmSessionKey:拉取支付宝收账
     */
    private String erpSessionKey;
    /**
     * crmSessionKey:御膳房拉取数据
     */
    private String crmSessionKey;

    /**
     * 直通车钻展token
     */
    private String accessToken;
    /**
     * facet:是否从仓库发货，1：是
     */
    private Integer facet;

    /**
     * 卖家id
     */
    private String sellerId;
    /**
     * 数据的前推时间默认是往前退4H，负数
     */
    private Integer forwardTime = -241;
    /**
     * 遍历增加时间
     * 默认一天
     */
    public Integer intervalTime = 60 * 24;

    /**
     * （2020.4.10为直钻超接口增加）
     * 取第前n天的数据
     */
    public Integer forwardDays;

    /**
     * Jhon：(2020.4.15增加通用数据推送参数ID)
     */
    public List<Integer> paramIdList;

    public List<Integer> shopCodeList;
    /**
     * oms店铺id
     */
    public String omsShopId;

    /*
    * 2020.4.14OMS多货主新增oms_db_name
    * */
    public String omsDbName;

    /**
     * 处理数据的条数
     */
    public int totalSize;

    /**
     * 报警类型 可选值：email sms
     */
    private String alarmType;

    /*
    * 财务收账类型   0 无 1 收账 2 订单
    * */
    private Integer receivedType;
    /**
     * 报警接收人 邮箱 或者短信
     */
    private List<String> toAddress;

    /**
     * 活动ID
     */
    private String activityParentId;

    /**
     * 需要去除的CRM标签
     */
    private String label;
    /**
     * BI数据库库名
     */
    private String repertoryNameBi;

    private Boolean isRealTime;

    /**
     * kettle插件是否存在
     */
    private String kettlePlugin;
    /**
     * 御膳房数据同步的数据分类id
     */
    public List<Integer> dataCode;

    /*
    * bi库名（仓库日志4.11增加）
    * */
    private List<String> biDbNames;

    /**
     * 2020.4.2 字符串入参集
     */
    private List<String> paramList;

    /**
     * 御膳房程序异常，沉睡时间
     */
    public Long sleepTime;
    /**
     * 品牌id
     */
    private int brandId;

    /*
    * 接口属性键值对
    * */
    private Map<String, Object> paramMap;


    /**
     * 大屏市场排行TOP店铺数
     */
    private int topSize;


    /**
     * 生意参谋爬取维度开关，备选项为day,week,month
     */
    private String sumType;

    /**
     * 生意参谋专用，用来判断是爬取所有店铺还是每个类目爬取一个店铺
     */
    private String sycmAllShop;

    /**
     * 生意参谋专用，用来判断是爬取当天所有店铺还是只爬取数据确实店铺
     */
    private String missingDataShop;


    /**
     * 接口名称
     */
    private String apiName;

    private boolean isFromDateBase;

    private boolean MQExe = true;

    private Integer pageNum;

    private Integer limitSize = 50 * 10000;

    public Integer getLimitSize() {
        return limitSize;
    }

    private List<String> tidList;

    private Integer shopStatus;

    private boolean omsShop;

    /**
     * 订单量
     */
    private Long tidNum = 0L;

    /*分片总数*/
    private Integer sectionTotal = 1;
    /*分片号*/
    private Integer sectionNum = 0;

    /**
     * 队列延时等级，0为不延时，延时等级说明参看TmOrderServiceImpl.DELAYLEVEL字段说明
     */
    private Integer delayLvl = 0;

    /**
     * appkey
     */
    private String appKey;

    /**
     * appsecret
     */
    private String appSecret;
}
