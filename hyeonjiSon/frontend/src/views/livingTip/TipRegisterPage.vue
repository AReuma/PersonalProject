<template>
<div align="center">
       <br>
       <h1> 게시글 작성 </h1>
       <br>
       <tip-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import TipRegisterForm from '@/components/livingTip/TipRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'TipRegisterPage',
    components: {
        TipRegisterForm
    },
    methods: {
      onSubmit (payload) {
        const { title, writer, content } = payload
        axios.post('http://localhost:7777/tipboard/register', { title, writer, content })
                .then(() => {
                    alert('게시물 등록 성공!')
                    this.$router.push({
                        name: 'livingTipBoardList'
                    })
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
    }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>