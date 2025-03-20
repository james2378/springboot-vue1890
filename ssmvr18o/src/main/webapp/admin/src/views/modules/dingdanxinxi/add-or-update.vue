<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="订单编号" prop="dingdanbianhao">
          <el-input v-model="ruleForm.dingdanbianhao" 
              placeholder="订单编号" clearable  :readonly="ro.dingdanbianhao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="订单编号" prop="dingdanbianhao">
              <el-input v-model="ruleForm.dingdanbianhao" 
                placeholder="订单编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="检查检验项目" prop="jianchajianyanxiangmu">
          <el-input v-model="ruleForm.jianchajianyanxiangmu" 
              placeholder="检查检验项目" clearable  :readonly="ro.jianchajianyanxiangmu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="检查检验项目" prop="jianchajianyanxiangmu">
              <el-input v-model="ruleForm.jianchajianyanxiangmu" 
                placeholder="检查检验项目" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="维修服务" prop="weixiufuwu">
          <el-input v-model="ruleForm.weixiufuwu" 
              placeholder="维修服务" clearable  :readonly="ro.weixiufuwu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="维修服务" prop="weixiufuwu">
              <el-input v-model="ruleForm.weixiufuwu" 
                placeholder="维修服务" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="派单时间" prop="paidanshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.paidanshijian" 
                type="datetime"
                placeholder="派单时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.paidanshijian" label="派单时间" prop="paidanshijian">
              <el-input v-model="ruleForm.paidanshijian" 
                placeholder="派单时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'" label="老人账号" prop="laorenzhanghao">
          <el-select  @change="laorenzhanghaoChange" v-model="ruleForm.laorenzhanghao" placeholder="请选择老人账号">
            <el-option
                v-for="(item,index) in laorenzhanghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input"v-if="ruleForm.laorenzhanghao" label="老人账号" prop="laorenzhanghao">
              <el-input v-model="ruleForm.laorenzhanghao" 
                placeholder="老人账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人姓名" prop="laorenxingming">
          <el-input v-model="ruleForm.laorenxingming" 
              placeholder="老人姓名" clearable  :readonly="ro.laorenxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人姓名" prop="laorenxingming">
              <el-input v-model="ruleForm.laorenxingming" 
                placeholder="老人姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人性别" prop="laorenxingbie">
          <el-input v-model="ruleForm.laorenxingbie" 
              placeholder="老人性别" clearable  :readonly="ro.laorenxingbie"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人性别" prop="laorenxingbie">
              <el-input v-model="ruleForm.laorenxingbie" 
                placeholder="老人性别" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人年龄" prop="laorennianling">
          <el-input v-model="ruleForm.laorennianling" 
              placeholder="老人年龄" clearable  :readonly="ro.laorennianling"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人年龄" prop="laorennianling">
              <el-input v-model="ruleForm.laorennianling" 
                placeholder="老人年龄" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.laorenzhaopian" label="老人照片" prop="laorenzhaopian">
          <file-upload
          tip="点击上传老人照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.laorenzhaopian?ruleForm.laorenzhaopian:''"
          @change="laorenzhaopianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.laorenzhaopian" label="老人照片" prop="laorenzhaopian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.laorenzhaopian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系地址" prop="lianxidizhi">
          <el-input v-model="ruleForm.lianxidizhi" 
              placeholder="联系地址" clearable  :readonly="ro.lianxidizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系地址" prop="lianxidizhi">
              <el-input v-model="ruleForm.lianxidizhi" 
                placeholder="联系地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老人当前状态" prop="laorendangqianzhuangtai">
          <el-input v-model="ruleForm.laorendangqianzhuangtai" 
              placeholder="老人当前状态" clearable  :readonly="ro.laorendangqianzhuangtai"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老人当前状态" prop="laorendangqianzhuangtai">
              <el-input v-model="ruleForm.laorendangqianzhuangtai" 
                placeholder="老人当前状态" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'" label="人员账号" prop="renyuanzhanghao">
          <el-select  @change="renyuanzhanghaoChange" v-model="ruleForm.renyuanzhanghao" placeholder="请选择人员账号">
            <el-option
                v-for="(item,index) in renyuanzhanghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input"v-if="ruleForm.renyuanzhanghao" label="人员账号" prop="renyuanzhanghao">
              <el-input v-model="ruleForm.renyuanzhanghao" 
                placeholder="人员账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="人员姓名" prop="renyuanxingming">
          <el-input v-model="ruleForm.renyuanxingming" 
              placeholder="人员姓名" clearable  :readonly="ro.renyuanxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="人员姓名" prop="renyuanxingming">
              <el-input v-model="ruleForm.renyuanxingming" 
                placeholder="人员姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao" 
              placeholder="手机号" clearable  :readonly="ro.shoujihao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="手机号" prop="shoujihao">
              <el-input v-model="ruleForm.shoujihao" 
                placeholder="手机号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="订单内容" prop="dingdanneirong">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="订单内容"
                  v-model="ruleForm.dingdanneirong" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.dingdanneirong" label="订单内容" prop="dingdanneirong">
                    <span>{{ruleForm.dingdanneirong}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="订单须知" prop="dingdanxuzhi">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="订单须知"
                  v-model="ruleForm.dingdanxuzhi" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.dingdanxuzhi" label="订单须知" prop="dingdanxuzhi">
                    <span>{{ruleForm.dingdanxuzhi}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(36, 194, 205, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"#ecf5ff","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	dingdanbianhao : false,
	jianchajianyanxiangmu : false,
	weixiufuwu : false,
	dingdanneirong : false,
	dingdanxuzhi : false,
	paidanshijian : false,
	laorenzhanghao : false,
	laorenxingming : false,
	laorenxingbie : false,
	laorennianling : false,
	laorenzhaopian : false,
	lianxidianhua : false,
	lianxidizhi : false,
	laorendangqianzhuangtai : false,
	renyuanzhanghao : false,
	renyuanxingming : false,
	shoujihao : false,
	userid : false,
      },
      ruleForm: {
        dingdanbianhao: '',
        jianchajianyanxiangmu: '',
        weixiufuwu: '',
        dingdanneirong: '',
        dingdanxuzhi: '',
        paidanshijian: '',
        laorenzhanghao: '',
        laorenxingming: '',
        laorenxingbie: '',
        laorennianling: '',
        laorenzhaopian: '',
        lianxidianhua: '',
        lianxidizhi: '',
        laorendangqianzhuangtai: '',
        renyuanzhanghao: '',
        renyuanxingming: '',
        shoujihao: '',
        userid: '',
      },
          laorenzhanghaoOptions: [],
          renyuanzhanghaoOptions: [],
      rules: {
          dingdanbianhao: [
          ],
          jianchajianyanxiangmu: [
          ],
          weixiufuwu: [
          ],
          dingdanneirong: [
          ],
          dingdanxuzhi: [
          ],
          paidanshijian: [
          ],
          laorenzhanghao: [
                { required: true, message: '老人账号不能为空', trigger: 'blur' },
          ],
          laorenxingming: [
          ],
          laorenxingbie: [
          ],
          laorennianling: [
          ],
          laorenzhaopian: [
          ],
          lianxidianhua: [
          ],
          lianxidizhi: [
          ],
          laorendangqianzhuangtai: [
          ],
          renyuanzhanghao: [
          ],
          renyuanxingming: [
          ],
          shoujihao: [
          ],
          userid: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
	this.ruleForm.paidanshijian = this.getCurDateTime()

	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='dingdanbianhao'){
            this.ruleForm.dingdanbianhao = obj[o];
	    this.ro.dingdanbianhao = true;
            continue;
          }
          if(o=='jianchajianyanxiangmu'){
            this.ruleForm.jianchajianyanxiangmu = obj[o];
	    this.ro.jianchajianyanxiangmu = true;
            continue;
          }
          if(o=='weixiufuwu'){
            this.ruleForm.weixiufuwu = obj[o];
	    this.ro.weixiufuwu = true;
            continue;
          }
          if(o=='dingdanneirong'){
            this.ruleForm.dingdanneirong = obj[o];
	    this.ro.dingdanneirong = true;
            continue;
          }
          if(o=='dingdanxuzhi'){
            this.ruleForm.dingdanxuzhi = obj[o];
	    this.ro.dingdanxuzhi = true;
            continue;
          }
          if(o=='paidanshijian'){
            this.ruleForm.paidanshijian = obj[o];
	    this.ro.paidanshijian = true;
            continue;
          }
          if(o=='laorenzhanghao'){
            this.ruleForm.laorenzhanghao = obj[o];
	    this.ro.laorenzhanghao = true;
            continue;
          }
          if(o=='laorenxingming'){
            this.ruleForm.laorenxingming = obj[o];
	    this.ro.laorenxingming = true;
            continue;
          }
          if(o=='laorenxingbie'){
            this.ruleForm.laorenxingbie = obj[o];
	    this.ro.laorenxingbie = true;
            continue;
          }
          if(o=='laorennianling'){
            this.ruleForm.laorennianling = obj[o];
	    this.ro.laorennianling = true;
            continue;
          }
          if(o=='laorenzhaopian'){
            this.ruleForm.laorenzhaopian = obj[o];
	    this.ro.laorenzhaopian = true;
            continue;
          }
          if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
	    this.ro.lianxidianhua = true;
            continue;
          }
          if(o=='lianxidizhi'){
            this.ruleForm.lianxidizhi = obj[o];
	    this.ro.lianxidizhi = true;
            continue;
          }
          if(o=='laorendangqianzhuangtai'){
            this.ruleForm.laorendangqianzhuangtai = obj[o];
	    this.ro.laorendangqianzhuangtai = true;
            continue;
          }
          if(o=='renyuanzhanghao'){
            this.ruleForm.renyuanzhanghao = obj[o];
	    this.ro.renyuanzhanghao = true;
            continue;
          }
          if(o=='renyuanxingming'){
            this.ruleForm.renyuanxingming = obj[o];
	    this.ro.renyuanxingming = true;
            continue;
          }
          if(o=='shoujihao'){
            this.ruleForm.shoujihao = obj[o];
	    this.ro.shoujihao = true;
            continue;
          }
          if(o=='userid'){
            this.ruleForm.userid = obj[o];
	    this.ro.userid = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
            this.$http({
              url: `option/laorendangan/laorenzhanghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.laorenzhanghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
            this.$http({
              url: `option/gongzuorenyuan/renyuanzhanghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.renyuanzhanghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
    },
    // 下二随
    laorenzhanghaoChange () {
      this.$http({
        url: `follow/laorendangan/laorenzhanghao?columnValue=`+ this.ruleForm.laorenzhanghao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
              if(data.data.laorenxingming){
                this.ruleForm.laorenxingming = data.data.laorenxingming
              }
              if(data.data.laorenxingbie){
                this.ruleForm.laorenxingbie = data.data.laorenxingbie
              }
              if(data.data.laorennianling){
                this.ruleForm.laorennianling = data.data.laorennianling
              }
              if(data.data.lianxidianhua){
                this.ruleForm.lianxidianhua = data.data.lianxidianhua
              }
              if(data.data.lianxidizhi){
                this.ruleForm.lianxidizhi = data.data.lianxidizhi
              }
              if(data.data.laorendangqianzhuangtai){
                this.ruleForm.laorendangqianzhuangtai = data.data.laorendangqianzhuangtai
              }
              if(data.data.renyuanxingming){
                this.ruleForm.renyuanxingming = data.data.renyuanxingming
              }
              if(data.data.shoujihao){
                this.ruleForm.shoujihao = data.data.shoujihao
              }
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 下二随
    renyuanzhanghaoChange () {
      this.$http({
        url: `follow/gongzuorenyuan/renyuanzhanghao?columnValue=`+ this.ruleForm.renyuanzhanghao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
              if(data.data.laorenxingming){
                this.ruleForm.laorenxingming = data.data.laorenxingming
              }
              if(data.data.laorenxingbie){
                this.ruleForm.laorenxingbie = data.data.laorenxingbie
              }
              if(data.data.laorennianling){
                this.ruleForm.laorennianling = data.data.laorennianling
              }
              if(data.data.lianxidianhua){
                this.ruleForm.lianxidianhua = data.data.lianxidianhua
              }
              if(data.data.lianxidizhi){
                this.ruleForm.lianxidizhi = data.data.lianxidizhi
              }
              if(data.data.laorendangqianzhuangtai){
                this.ruleForm.laorendangqianzhuangtai = data.data.laorendangqianzhuangtai
              }
              if(data.data.renyuanxingming){
                this.ruleForm.renyuanxingming = data.data.renyuanxingming
              }
              if(data.data.shoujihao){
                this.ruleForm.shoujihao = data.data.shoujihao
              }
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `dingdanxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}
      // ${column.compare}


















      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `dingdanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    laorenzhaopianUploadChange(fileUrls) {
	this.ruleForm.laorenzhaopian = fileUrls;
			this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
