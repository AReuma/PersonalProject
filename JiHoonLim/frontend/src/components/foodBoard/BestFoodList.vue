<template>
  <div style="font-family: 'Noto Sans KR', sans-serif">
    <v-container class="white" style="width: 1400px">
      <v-row>
        <v-col>
          <div class="mb-10">
            <div
              style="
                font-size: 70px;
                text-align: center;
                font-weight: bold;
                margin-bottom: 10px;
              "
            >
              R A N K
            </div>
            <div
              style="
                font-size: 20px;
                text-align: center;
                font-weight: bold;
                color: grey;
              "
            >
              Easy Cook 에서 많은 분들이 찾아본 인기 레시피
              <b style="color: orange">TOP 12</b> 을 소개합니다.
            </div>
          </div>
          <v-divider></v-divider>
        </v-col>
      </v-row>

      <v-row class="mt-10 ml-5 mr-5 mb-10">
        <v-col
          v-for="(food, index) in bestFoodBoards"
          :key="food.boardNo"
          lg="3"
          sm="6"
        >
          <v-card width="500" height="380" class="mt-3 mb-3">
            <div v-if="index == 0" style="position: relative">
              <div class="rankNum">
                <v-img
                  width="80px"
                  height="100px"
                  src="@/assets/img/gold.png"
                  class="gold"
                />
              </div>
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <div v-else-if="index == 1" style="position: relative">
              <div class="rankNum">
                <v-img
                  width="150px"
                  height="100%"
                  src="@/assets/img/silver.png"
                  class="silver"
                />
              </div>
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <div v-else-if="index == 2" style="position: relative">
              <div class="rankNum">
                <v-img
                  width="135px"
                  height="100%"
                  src="@/assets/img/bronze.png"
                  class="bronze"
                />
              </div>
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <div v-else style="position: relative">
              <router-link
                :to="{
                  name: 'FoodDetailPage',
                  params: { boardNo: food.boardNo },
                }"
              >
                <v-img
                  :src="
                    require(`@/assets/uploadImg/foodBoard/${food.filename}`)
                  "
                  height="200px"
                ></v-img>
              </router-link>
            </div>
            <v-card-subtitle class="pt-3 pb-0"
              ><v-chip class="ma-1" small>
                {{ food.mat }}
              </v-chip>
              <v-chip class="ma-1" small> {{ food.kind }} </v-chip>
              <v-chip class="ma-1" small> {{ food.way }} </v-chip>
            </v-card-subtitle>

            <v-card-title class="pt-0 pb-0"> {{ food.name }} </v-card-title>

            <v-card-actions>
              <v-card-text class="pb-0 pt-0">{{ food.writer }}</v-card-text>
            </v-card-actions>
            <v-card-actions>
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange" class="pr-1"> mdi-thumb-up</v-icon>
                {{ food.likeCount }}</v-card-text
              >
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange" class="pr-1">mdi-eye</v-icon
                >{{ food.viewCount }}</v-card-text
              >
              <v-card-text class="food_sub_icon"
                ><v-icon color="orange" class="pr-1">mdi-comment</v-icon
                >{{ food.commentCnt }}</v-card-text
              >
            </v-card-actions>
            <v-card-actions class="pl-0 pb-0 pt-0">
              <v-card-text class="food_date">{{ food.regDate }}</v-card-text>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "BestFoodList",
  props: {
    bestFoodBoards: {
      type: Array,
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap");
.btn-cover .page-count {
  padding: 0 1rem;
}
.food_sub_icon {
  padding: 0;
  text-align: center;
}
.food_date {
  padding: 0;
  text-align: right;
  color: grey;
}
.rankNum {
  position: absolute;
  top: -9%;
  left: -9%;
  z-index: 100;
}
.main_tit {
  font-size: 36px;
  color: orange;
  font-style: italic;
}
.main_tit_box {
  text-align: center;
  font-size: 30px;
  color: #333;
  padding: 8px 0 8px 0;
  font-style: italic;
  position: relative;
}

.gold {
  right: 18px;
  top: -12px;
}
.silver {
  right: 45px;
  top: -30px;
}
.bronze {
  right: 40px;
  top: -20px;
}
</style>
