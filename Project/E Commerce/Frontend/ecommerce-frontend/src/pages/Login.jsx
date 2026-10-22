import React from 'react'
import { useForm } from "react-hook-form";
import axios from 'axios'

const Login = () => {
  const {register,handleSubmit}=useForm();
  function login(data){
    console.log(data.email+" "+data.password)
    axios.post(
      "http://localhost:8080/auth/login",
      {"email": data.email, "password": data.password},
      {headers:{"Content-Type": "application/json"}}
    ).then(
      (response)=>{
        localStorage.setItem("token",response.data.token)
        const token=localStorage.getItem("token")
        console.log(token)
      }
    ).catch(
      (err)=>{
        console.log(err)
      }
    )
  }
  return (
    <>
      <h1>Login</h1>
      <form onSubmit={handleSubmit(login)}>
        <input {...register("email")} /><br/>
        <input {...register("password")} /><br/>
        <button type="submit">Submit</button>
      </form>
    </>
  )
}

export default Login