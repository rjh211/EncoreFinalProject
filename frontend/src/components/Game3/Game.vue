<template>
  <div>
      음식 명 : <input type="text" v-model="word"><br/>
      검색 개수 : <input type="text" v-model="searchCount"><br/>
      <button @click="callSearchApi">검색</button><br/>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            word:'김치찌개',
            searchCount:5
        }
    },
    methods:{
        callSearchApi(){
            axios.get('http://localhost:8000/callSearchAPI?word='+this.word + '&count=' + this.searchCount)
            .then((res)=>{
                if(res.data) alert('꽝 입니다.');
                this.word = '';
                this.searchCount = '';
            })
        }
    }
}
</script>

<style>

</style>