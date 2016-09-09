package com.qzw.common.exception.MapperSupport.Constant;

/**
 * Created by admin on 2016/6/24.
 */
public enum WebExceptionType {


    LOGINNOTFUND("不存在的登录账号！"),
    REQUIRELOGINED("用户未登录！"),
    INVALIDNEWPASSWD("无效的新密码！"),
    INVALIDOLDPASSWD("原始密码不正确！"),
    LOGININVALIDPASSWD("无效的登录密码！"),
    LOGININVALIDSTATUS("用户状态异常！"),
    USERACCOUNTDUPLICATE("重复的用户信息！"),
    ROLENAMEDUPLICATE("重复的角色信息！"),

    //用户基本信息
    USERNOTFUND("用户不存在！"),
    COUNTERNOTFOUND("计数类型不存在！"),
    USERPHONEEMAIL("手机号不存在或邮箱不存在"),
    USERPASSWORD("原密码错误，修改失败"),
    USERPHONENOTNULL("手机号不能为空"),
    VERIFYCODE("验证码错误"),
    USERPHONEEXISTS("手机号已存在"),
    GETPHONEEXISTS("手机号获取失败"),
    UPDATEPHONEEXISTS("手机号修改失败"),
    USEREMAILEXISTS("邮箱已存在已存在"),
    UPDATEEMAILEXISTS("邮箱修改失败"),
    USEREMAILNOTNULL("邮箱不能为空"),
    INSERTINVALIDREALNAME("添加实名信息失败"),
    VERIFICATIONCODEERROR("验证码错误"),
    //账户
    UPDATEPAYPWDACCUSERBANK("修改支付密码"),
    INSERTINVALIDACCUSERBANK("绑定银行卡失败"),
    GETINVALIDACCUSERBANK("银行卡信息查询失败"),
    USERTYPEEXISTS("你没有权利绑定手机号"),
    //收货地址
    DELETEPOSTACCESS("删除收货地址失败"),
    INSERTPOSTACCESS("收货地址添加失败"),
    UPDATEPOSTACCESS("收货地址修改失败"),
    UPDATEINVALIDUSERINFO("用户信息修改异常！"),
    GETRINVALADDRESS("收货地址获取失败"),

    //发起项目
    PUBLISHINVALIDPROJECT("发起项目失败！"),
    PUBLISHINVALIDPROJECTINFO("获取发起项目信息失败！"),


    //项目回报设置
    DELETEINVALIDPROEJCTRETURNSET("删除项目回报异常！"),
    UPDATEINVALIDPROEJCTRETURNSET("更新项目回报异常！"),
    CROWDFUNDRETURNSETNOTFUND("项目回报不存在！"),

    POSTACCESSNOTFUND("收货地址不存在"),
    //添加
    INSERTINVALIDDYNAMIC("添加失败！"),
    //查询我的私信列表
    GETINVALIDCROWDFUNDCOMMENT("获取信息列表失败"),
    //我关注的项目列表
    GETINVALIDPROJECTCONCERNS("获取信息列表失败"),
    //我发起的项目列表
    GETINVALIDLAUNCHPROJECT("获取列表失败"),
    //查询项目列表
    SELECTINVALIDHOT("获取项目列表失败"),
    //查询我的私信列表
    GETINVALIDPROJECTLETTER("获取我的私信失败"),
    //删除私信
    DELETEINVALIDPROJECTLETTER("删除私信失败"),
    //我支持的项目列表
    UPLOADINVALIDIMG("图片上传失败！"),
    //发起人信息
    GETINVALIDLAUNCHPEOPELINFORMATION("获取发起人信息失败"),
    GETINVALIDPROJECTSUPPORT("获取支持项目失败"),
    GETINVALIDORDERLIST("获取订单列表失败"),
    //查询回复列表
    SELECTINVALIDREPLY("获取回复列表失败"),

    //删除店铺失败
    DELETEINVALIDSHOP("删除店铺失败"),
    //获取所有信息列表
    GETICROWDFUNDCOMMENT("获取信息列表失败"),
    //获取店铺的详细信息
    SELECTINVALIDDETAILS("获取信息失败"),
    //修改店铺
    UPDATEINVALIDSHOP("修改失败"),

    ERROR_ALREADYHAVE("数据已经存在"),

    //上传参数错误
    ERROR_REQUEST("上传参数异常"),
    ERROR_REQUEST_EMPTY("参数不能为空"),
    //店铺提交失败
    INSERTORUPDATEINVALIDSUBMIT("修改或添加失败");


























    private WebExceptionType(String value){
        this.type = value;
    }

    private String type;


    @Override
    public String toString() {
        return this.type;
    }
}
