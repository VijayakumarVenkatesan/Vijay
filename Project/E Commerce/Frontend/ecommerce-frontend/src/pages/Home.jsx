import React from 'react'

const Home = () => {
  function token(){
    const printToken=localStorage.getItem("token")
    if(printToken==null){
      console.log("Please log in")
      return
    }
    console.log(printToken)
  }
  function logout(){
    const printToken=localStorage.getItem("token")
    if(printToken==null){
      console.log("Already Log out")
      return
    }
    localStorage.removeItem("token")
    console.log("Logout")
  }
  return (
    <div>
      <h1>Home</h1>
      <button onClick={token}>Token</button>
      <button onClick={logout}>logout</button>
    </div>
  )
}

export default Home