<template>
  <div :style="cardStyle" @click="OnClickColor">{{data}}</div>
</template>

<script>
export default {
    data(){
        return {
            cardStyle :{
                border : '1px solid black',
                width : '40px',
                height :'40px',
                'text-align': 'center',
                'background-color' : 'black',
                margin : '1px'
            }
        }
    },
    props:{
        data : String
    },
    methods:{
        OnClickColor(){
            this.cardStyle['background-color'] = '#ffffff';
            this.$parent.playerCount++;
            if(this.data){
                this.$parent.gameEnd = true;
            }
        }
    }
}
</script>

<style scoped>

</style>