<template>
  <body>
    <div class="login">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="visually-hidden">
              <h1>Nike</h1>
            </header>

            <div class="login-container">
              <div class="login-header">
                <h2>로그인</h2>
              </div>

              <section class="login-section">
                <div class="login-member">
                  <form
                    class="login-form"
                    action="/"
                    method="POST"
                    @submit.prevent="onSubmit"
                  >
                    <div class="login-member-form">
                      <div class="login-member-id">
                        <input
                          class="login-input"
                          type="text"
                          placeholder="아이디를 입력해주세요"
                          v-model="id"
                          required
                        />
                      </div>
                      <div class="login-member-password">
                        <input
                          class="login-input"
                          type="password"
                          placeholder="비밀번호를 입력해주세요"
                          v-model="pw"
                          required
                        />
                      </div>
                    </div>

                    <div class="login-button">
                      <button
                        class="btn-black btn-46"
                        type="submit"
                        @click="onSubmit"
                      >
                        로그인
                      </button>
                    </div>
                    <div class="login-util">
                      <div class="login-util-check">
                        <input type="checkbox" />
                        <label for="">자동로그인</label>
                      </div>

                      <div>
                        <ul class="login-util-find">
                          <li class="login-util-find id">
                            <router-link
                              :to="{ name: 'IdPage' }"
                              class="routerlink"
                              >아이디 찾기</router-link
                            >
                          </li>
                          <li class="login-util-find password">
                            <router-link :to="{ name: 'PasswordPage' }"
                              >비밀번호 찾기</router-link
                            >
                          </li>
                        </ul>
                      </div>
                    </div>
                  </form>

                  <div>
                    <a
                      href="https://kauth.kakao.com/oauth/authorize?client_id=${92f347c8d65782843d4cebadfc7ca6d0}&redirect_uri=${	
https://localhost:8080/auth/kakao/callback}&response_type=code"
                    >
                      <button class="login-btn-kakao">카카오 로그인</button>
                    </a>
                  </div>
                  <div>
                    <button class="login-btn-naver">네이버 로그인</button>
                  </div>
                </div>

                <div class="login-bottom-text">
                  <span>가입만 해도 즉시 15% 할인</span>
                  <router-link :to="{ name: 'SignPage' }">회원가입</router-link>
                </div>
              </section>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>
<script>
export default {
  name: "LoginPageForm",
  data() {
    return {
      id: "",
      pw: "",
    }
  },
  props: {
    members: {
      type: Array,
    },
  },
  methods: {
    onSubmit() {
      const { id, pw } = this
      this.$emit("submit", { id, pw })
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/pages/login";
</style>
