<template>
  <v-row>
    <v-col>
      <v-btn fab class="float-right">
        <v-menu offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" fab>
              <v-icon x-large>mdi-lead-pencil</v-icon>
            </v-btn>
          </template>

          <v-list dense>
            <v-list-item-group>
              <v-list-item @click="showDialog" style="font-size: 25px">일정</v-list-item>
            </v-list-item-group>
          </v-list>
        </v-menu>
      </v-btn>

      <v-dialog width="800" v-model="makePlan">
        <v-card>
          <v-row justify="center">
            <v-card-title>
              <span style="font-size: 40px; color: darkolivegreen"><br/>여행 계획을 작성해보아요! </span>
            </v-card-title>
          </v-row>

          <v-card-text>
              <form @submit="onSubmit">
                <table>
                  <tr>
                    <td colspan="2" class="plan">여행 이름</td>
                  </tr>

                  <tr>
                    <td colspan="2">&nbsp;&nbsp;<input class="inputBox" type="text" placeholder="make trip name!"  style="width: 300px" v-model="planName" required></td>
                  </tr>
                  <tr></tr>
                  <tr>
                    <td class="plan"> 여행 일정 </td>
                    <td> <v-btn @click="showDatePicker" fab><v-icon x-large>mdi-calendar-multiselect</v-icon></v-btn> &nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td> <input type="text" readonly v-model="planDate" style="width: 300px" placeholder="range date" required></td>
                  </tr>
                  <tr></tr>
                  <tr></tr>
                  <tr>
                    <td colspan="2" class="plan">여행 장소</td>
                  </tr>

                  <tr>
                    <td colspan="2">&nbsp;&nbsp;<input type="text" class="inputBox" placeholder="trip place!" style="width: 300px" v-model="placeName" required></td>
                  </tr>

                </table>
              </form>

              <div style="margin-top: 10px">
                <label>
                  <input style="font-size: 30px" type="file" id="files" ref="files" multiple v-on:change="fileUpload()">
                  <label style="color: red; font-size: 20px">** 배경 사진 한장 선택해주세요!</label>
                </label>
              </div>

              <v-dialog max-width="400" v-model="pickDate" light>
                <v-date-picker v-model="dates" range></v-date-picker>
              </v-dialog>

          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="makePlan = false">Close</v-btn>
            <v-btn @click="onSubmit" color="green darken-1">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-col>
  </v-row>
</template>

<script>
import axios from "axios";

export default {
  name: "BeforePencilIcon",
  data() {
    return{
      makePlan: false,
      pickDate: false,
      dates: ['', ''],
      planName: '',
      placeName: '',
      files: '',
    }
  },
  props:{
    id: {
      type: String
    }
  },
  methods: {
    showDialog() {
      this.makePlan = true
    },
    showDatePicker(){
      this.pickDate = true
    },
    onSubmit(){
      /*const {planName, planDate, placeName} = this;

      console.log({planName, planDate, placeName});
      this.makePlan = false;
      this.$emit('submit',{planName, planDate, placeName});*/

      let formData = new FormData;

      if (this.files.length === 0) {
        alert("사직을 하나 이상 입력해주세요!!!")
      } else {
        for (let i = 0; i < this.files.length; i++) {
          console.log(this.files[i])
          formData.append('fileList', this.files[i])
        }

        formData.append('planName', this.planName)
        formData.append('planDate', this.planDate)
        formData.append('placeName', this.placeName)
        formData.append('id', this.id)

        this.$emit('submit', formData);

        axios.post('http://localhost:7777/plan/makePlan', formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        })
            .then((res) => {
              console.log(res);
              this.$router.go();
            })
            .catch((res) => {
              console.log(res.response.data.message);
            })
      }
    },
    fileUpload(){
      this.files = this.$refs.files.files
    },
  },
  computed: {
    planDate () {
      return this.dates.join(' ~ ')
    },
  },
}
</script>

<style scoped>
table {
  border-collapse:  separate;
  border-spacing: 0 1rem;
}
.plan{
  font-size: 30px;
}
input{
  font-size: 20px;
}
/*td{
  border: 1px solid black;
  font-size: 20px;
}*/

</style>