<template>
  <div>
    음식 명 : <input type="text" v-model="word"><br/>
    검색 개수 : <input type="text" v-model="searchCount"><br/>
    <button @click="callSearchApi">검색</button><br/>
    <p id="res"></p>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data(){
        return{
            word:'김치찌개',
            searchCount:5,
            result : '<li>'
        }
    },
    methods:{
        callSearchApi(){
            this.result = '<li>'
            axios.get('http://localhost:8000/callSearchAPI?word='+this.word + '&count=' + this.searchCount)
            .then((res)=>{
                const items = res.data;
                for(let i = 0 ;i <items.length;i++){
                    let title = items[i].title.replace(/(<b>|<\/b>)/g,'');
                    let description = items[i].description.replace(/(<b>|<\/b>)/g,'');

                    title = title.replace('백종원',`<span style = "background-color : red">백종원</span>`);
                    description = description.replace('백종원',`<span style = "background-color : red">백종원</span>`);

                    this.result += title +'</li><br/><li>';
                    this.result += description +'</li><br/>';
                }
                if(this.result.indexOf('백종원') >= 0) alert('당첨되었습니다.');
                else alert('통과')
                document.getElementById('res').innerHTML = this.result;
            })
        }
    }
}
</script>

<style>

</style>