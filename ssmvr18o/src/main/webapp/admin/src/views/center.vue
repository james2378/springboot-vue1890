<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='laorenzhanghao'"  label="老人账号" prop="laorenzhanghao">
          <el-input v-model="ruleForm.laorenzhanghao" readonly              placeholder="老人账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='laorenzhanghao'"  label="老人姓名" prop="laorenxingming">
          <el-input v-model="ruleForm.laorenxingming"               placeholder="老人姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='laorenzhanghao'"  label="老人性别" prop="laorenxingbie">
          <el-select v-model="ruleForm.laorenxingbie" placeholder="请选择老人性别">
            <el-option
                v-for="(item,index) in laorenzhanghaolaorenxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='laorenzhanghao'"  label="老人年龄" prop="laorennianling">
          <el-input v-model="ruleForm.laorennianling"               placeholder="老人年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='laorenzhanghao'" label="老人照片" prop="laorenzhaopian">
          <file-upload
          tip="点击上传老人照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.laorenzhaopian?ruleForm.laorenzhaopian:''"
          @change="laorenzhanghaolaorenzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='laorenzhanghao'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='laorenzhanghao'"  label="联系地址" prop="lianxidizhi">
          <el-input v-model="ruleForm.lianxidizhi"               placeholder="联系地址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='gongzuorenyuan'"  label="人员账号" prop="renyuanzhanghao">
          <el-input v-model="ruleForm.renyuanzhanghao" readonly              placeholder="人员账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='gongzuorenyuan'"  label="人员姓名" prop="renyuanxingming">
          <el-input v-model="ruleForm.renyuanxingming"               placeholder="人员姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='gongzuorenyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in gongzuorenyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='gongzuorenyuan'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='gongzuorenyuan'"  label="人员类型" prop="renyuanleixing">
          <el-select v-model="ruleForm.renyuanleixing" placeholder="请选择人员类型">
            <el-option
                v-for="(item,index) in gongzuorenyuanrenyuanleixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='gongzuorenyuan'" label="照片" prop="zhaopian">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
          @change="gongzuorenyuanzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='gongzuorenyuan'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao"               placeholder="手机号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='gongzuorenyuan'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      laorenzhanghaolaorenxingbieOptions: [],
      gongzuorenyuanxingbieOptions: [],
      gongzuorenyuanrenyuanleixingOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.laorenzhanghaolaorenxingbieOptions = "男,女".split(',')
    this.gongzuorenyuanxingbieOptions = "男,女".split(',')
    this.gongzuorenyuanrenyuanleixingOptions = "工作人员,志愿者".split(',')
  },
  methods: {
    laorenzhanghaolaorenzhaopianUploadChange(fileUrls) {
        this.ruleForm.laorenzhaopian = fileUrls;
    },
    gongzuorenyuanzhaopianUploadChange(fileUrls) {
        this.ruleForm.zhaopian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.laorenzhanghao)&& 'laorenzhanghao'==this.flag){
        this.$message.error('老人账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'laorenzhanghao'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.laorennianling)&& 'laorenzhanghao'==this.flag){
        this.$message.error('老人年龄不能为空');
        return
      }
      if( 'laorenzhanghao' ==this.flag && this.ruleForm.laorennianling&&(!isIntNumer(this.ruleForm.laorennianling))){
       this.$message.error(`老人年龄应输入整数`);
        return
      }
      if( 'laorenzhanghao' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if((!this.ruleForm.renyuanzhanghao)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('人员账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'gongzuorenyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'gongzuorenyuan' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if( 'gongzuorenyuan' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入手机格式`);
        return
      }
      if( 'gongzuorenyuan' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
