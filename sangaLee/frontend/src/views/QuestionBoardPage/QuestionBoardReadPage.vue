<template>
    <div align="center">
        <h2>Vue + Spring 게시판 읽기</h2>
        <board-read v-if="board" :board="board"/>
        <p v-else>로딩중 ....... </p>
        <router-link :to="{ name: 'QuestionBoardModifyPage', params: { boardNo } }">
            게시물 수정
        </router-link>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'QuestionBoardListPage' }">
            게시물 보기
        </router-link>
    </div>
</template>

<script>

import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import QuestionBoardRead from '@/components/QuestionBoard/QuestionBoardRead.vue'

export default {
    name: 'QuestionBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    components: {
        QuestionBoardRead
    },
    computed: {
        ...mapState(['board'])
    },
    created () {
        this.fetchBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchBoard']),
        onDelete () {
            const { boardNo } = this.board
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/QuestionBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'BoardListPage' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }
}

</script>