import React from 'react'
import { useForm } from "react-hook-form";
import axios from 'axios'

const Signup = () => {
  const {register,handleSubmit}=useForm();
  function signup(data){
    console.log("Signup")
    console.log(data)
    axios.post(
      "http://localhost:8080/auth/signup",
      {
        "name": data.name,
        "email": data.email, 
        "password": data.password
      },
      {headers:{"Content-Type": "application/json"}}
    ).then(
      (response)=>{
        console.log(response)
      }
    ).catch(
      (err)=>{
        console.log(err)
      }
    )
  }
  return (
    <div>
      <h1>Signup</h1>
      <form onSubmit={handleSubmit(signup)}>
        <input {...register("name")} /><br/>
        <input {...register("email")} /><br/>
        <input {...register("password")} /><br/>
        <button type="submit">Submit</button>
      </form>
    </div>
  )
}

export default Signup