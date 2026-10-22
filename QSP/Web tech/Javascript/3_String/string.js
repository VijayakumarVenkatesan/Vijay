let str1=`Hello `
let str2=`I am STR2 ${str1}`
let str3=`I am STR3 ${str1}`
console.log(typeof str1,str1)
console.log(typeof str2,str2)
console.log(typeof str3,str3)
let upper=str1.toUpperCase()
let lower=str1.toLowerCase()
console.log(upper)
console.log(lower)
console.log(str1.trim())
console.log(str1.lastIndexOf('l'))
function rev(str){
    let newStr=""
    for(let i=str.length-1;i>=0;i--){
        newStr=newStr+str.charAt(i);
    }
    return newStr
}
let Rev=rev(str1).trim()
console.log(Rev)
let arr=[1,2,3,4,5]
let arrRev=(arr)=>{
    let left=0,right=arr.length-1;
    while(left<right){
        const temp=arr[left]
        arr[left]=arr[right]
        arr[right]=temp
        left++;
        right--;
    }
    return arr;
}
let strRev=(str)=>{
    let arr=str.split('')
    arrRev(arr)
    let result=""
    arr.forEach(element => {
        result+=element        
    })
    return result
}
console.log(arr)
arrRev(arr)
console.log(arr)
let StrRev=strRev(str1).trim()
console.log(StrRev)