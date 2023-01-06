const location = document.getElementById('location')
const form = document.getElementById('form')
form.addEventListener('submit',(e)=>{
	if(location.value===''|| location.value==null){
		messages.push('Locatiob required')
	}
	if(messages.length>0){
		e.preventDefault()
		errorElement.innerTest = messages.join(',')
	}
	
})
