let arr=[11,23,21,13,14,7]
let max=-1/0,max2=-1/0;
for(let i=0;i<arr.length;i++){
    if(arr[i]>max){
        max2=max;
        max=arr[i];
    } 
    else if(arr[i]>max2){
        max2=arr[i];
    }
}
console.log(max==max2 || max2==-10/0? "No second maximum" : "Second maximum "+max2)   
console.log("Before rotation "+arr)
function leftRotation(arr){
    let a=arr[0]
    for(let i=0;i<arr.length-1;i++){
        arr[i]=arr[i+1]
    }
    arr[arr.length-1]=a
}
function rightRotation(arr){
    let a=arr[arr.length-1]
    for(let i=arr.length-1;i>0;i--){
        arr[i]=arr[i-1];
    }
    arr[0]=a
}
leftRotation(arr)
console.log("After left rotation "+arr)
rightRotation(arr)
console.log("After right rotation "+arr)
let arr2=arr.map((item,index)=>(item*2))
console.log("Multiply by 2 using map "+arr2)