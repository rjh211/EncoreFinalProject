<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Game/>
  </div>
</template>

<script>
import Game from './components/Game1/Game'
export default {
  name: 'App',
  components: {
    Game
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
