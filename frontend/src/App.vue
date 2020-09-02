<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Game3/>
  </div>
</template>

<script>
//import Game from './components/Game1/Game'
//import Game2 from './components/Game2/Game'
import Game3 from './components/Game3/Game'
export default {
  name: 'App',
  components: {
    //Game,
    //Game2
    Game3
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
