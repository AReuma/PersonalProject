<template>
    <div>
        <v-container style="width: 700px; margin-top: 85px; padding-left: 0px">
            <v-flex>
                <v-card style="height: 620px">
                    <br/>
          <div style="display: flex; justify-content: center;">
          <form @submit.prevent="onSubmit"  >
            <table>
              <tr>
                  <td style="padding-left: 120px;  margin: 6px 0px 0px 62px;">
                    <div style="border-radius: 70%; overflow: hidden;">
                      <v-img v-if="member.imageName" width="38" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                      <v-img v-else width="38" src="@/assets/profile.jpg"/>
                    </div>
                  </td>
                  <td style="padding-left: 10px; font-size: 24px">
                      {{member.memberId}}
                  </td>
              </tr>
              <br/>
              <tr>
                  <td style="text-align: right; padding-right: 10px">새 비밀번호</td>
                  <td>
                    <input style="
                    background-color: #FAFAFA;
                    margin: 3px;
                    border: 1px solid #d6d6d6; 
                    border-radius: 3px; 
                    width: 300px; 
                    height: 35px;
                    padding-left: 5px;" 
                    type="password" v-model="password" />
                  </td>
              </tr>
              


            </table>
            <br/>
            <div style="text-align: center">
              <v-btn style="height: 30px;" color="blue" class="white--text" type="submit">비밀번호 변경</v-btn>
            </div>
          </form>
          </div>
          <br/>
                </v-card>
            </v-flex>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'PasswordEditForm',
    props: {
      member: {
        type: Object,
        require:true
      }
    },
    data() {
      return {
        password: ''
      }
    },
    methods: {
      onSubmit() {
        const { password } = this
        this.$emit('submit', { password})
      }
    },
    created() {
      this.password = ''
    }
}
</script>