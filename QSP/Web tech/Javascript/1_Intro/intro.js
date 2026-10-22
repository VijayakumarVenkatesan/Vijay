let arr=[{"Name":"Vijay"},100,true,"V",(a,b)=>{console.log(a+b)}]
console.log(arr)
arr[4](100,100)
console.log(typeof(arr[4]))
arr.forEach((a)=>{
    console.log("Type of "+a+" is "+typeof(a))
})