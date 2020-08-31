<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Game/>
    <button @click="test">test</button>
  </div>
</template>

<script>
import Game from './components/Game1/Game'
import axios from 'axios'
export default {
  name: 'App',
  components: {
    Game
  },
  methods:{
    test (){
      axios.get('http://localhost:8000/members')
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
