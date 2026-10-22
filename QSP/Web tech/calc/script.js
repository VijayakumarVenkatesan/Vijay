let result=document.getElementById('result')
let button=document.querySelectorAll('.button')
let evaluate=document.getElementById('evaluate')
let clr=document.getElementById('clr')
let del=document.getElementById('del')
button.forEach(btn => {
    btn.addEventListener('click',() =>{
        result.value+=btn.textContent
    })
})
evaluate.addEventListener('click',()=>{
    result.value=eval(result.value)
})
clr.addEventListener('click',()=>{
    result.value="";
})
del.addEventListener('click',()=>{
    result.value=result.value.slice(0,result.value.length-1)
})
