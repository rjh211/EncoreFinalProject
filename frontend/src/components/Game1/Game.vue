<template>
    <div>
        <div v-if="!gameEnd">
            <div v-if="hideLoginForm">
                <input v-model="peopleNum" placeholder="인원수 : 최대 10명">
                <input v-model="cardNum" placeholder="카드수"><br/>
                <button @click="LoginClick">입력</button>
            </div>
            <div v-else>
                <p v-for="card in cardList" :key="card">
                    <card-component :data = card></card-component>
                </p>
            </div>
        </div>
        <div v-else>
            {{OnResult()}}
            <button @click="OnClickReset">다시하기</button>
            <button @click="OnClickList">목록으로</button>
        </div>
    </div>
</template>

<script>
import CardComponent from './components/card'
export default {
    data(){
        return {
            peopleNum : null,
            cardNum : null,
            hideLoginForm : true,
            cardList : [],
            gameEnd : false,
            playerCount : -1
        }
    },
    methods : {
        LoginClick(){
            if(this.peopleNum <= 10 && this.peopleNum > 0 && this.peopleNum && this.cardNum > 0 && this.cardNum){
                this.cardList = Array.from({length : this.cardNum}, () => null);
                let randomNumber = Math.floor(Math.random() * this.cardNum);
                this.cardList[randomNumber] = 'O';
                this.hideLoginForm = false
            }
            else{
                alert('다시 입력하세요.');
                this.peopleNum = null;
                this.cardNum = null;
            }
        },
        OnClickReset(){
            this.gameEnd = false;
            this.playerCount = -1;
            this.hideLoginForm = true;
        },
        OnClickList(){
            //목록 나오면 추가
        },
        OnResult(){
            alert((this.playerCount % this.peopleNum)+1+'번째 플레이어 당첨');
        }
    },
    components:{
        CardComponent
    },
    watch:{
        peopleNum(){
            return this.peopleNum = this.peopleNum.replace(/[^0-9]/g, '');
        },
        cardNum(){
            return this.cardNum = this.cardNum.replace(/[^0-9]/g, '');
        }
    }
}
</script>

<style>
    
</style>