<template>
    <div class="loginForm">
        <form @submit.prevent="onSubmit">
            <br>
            <h4>로그인</h4>
            
            <v-container >
                <v-row style="width: 80%; padding: 20px 0 0 0;">
                    <v-icon>mdi-account</v-icon>
                    <v-text-field flat v-model="id" type="text"  dense required placeholder="아이디 입력" :rules="rules_id" ></v-text-field>
                </v-row>
                <v-row style="width: 80%; padding: 20px 0 0 0;">
                    <v-icon>mdi-lock</v-icon>
                    <v-text-field flat v-model="pw" type="password"  dense required placeholder="비밀번호 입력" :rules="rules_pw" ></v-text-field>
                </v-row>
            </v-container>

            <div>
                <br>
                <v-btn color="black" text type="submit" width="210">
                    <v-icon>mdi-login</v-icon>login</v-btn>
                
                <br>
                <br>
                
                <v-btn @click="signUp" color="black" text type="button" width="210">
                <v-icon>mdi-account-circle</v-icon>회원가입</v-btn>
                    
                
            </div>
        </form>
    </div>
</template>

<script>
export default {
    name : 'LoginPageForm',
    data() {
        return {
            id: '',
            pw: '',
            rules_id: [
                    v => !!v || '아이디를 입력해주세요'
            ],
            rules_pw: [
                v => !!v || '비밀번호를 입력해주세요',
            ]
        }
    },
    methods: {
        onSubmit () {
            const {id,pw} = this
            this.$emit('submit',{id,pw})
        },
        signUp () {
            this.$router.push({
                    name: 'SignUpPage'
                })
        }
    }
}
    
</script>

<style scoped>

.loginForm {
    padding: 10%;
    margin: 2%;
}


input {
    border: double 1px black;
    border-radius:5px;
    outline: none;
    background-color: rgb(245, 190, 190);
}

span {
    text-decoration: none;
    display: inline-block;
    height: 20px;
    width: 200px;
    font-size: 10pt;
    text-align: right;
}

router-link{
    color : black;
}

a {
    text-decoration: none;
    color : black;
}

h4 {
    display: inline-block;
    height: 30px;
    width: 200px;
    text-align: left;
}

form {
    border: 3px solid rgb(243, 180, 180);
    width: 306px;
    height: 350px;
}

</style>