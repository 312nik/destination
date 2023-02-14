$(async function() {
    await addNewUser()
});



async function addNewUser() {

    $('#addNewUser').on('click', async function (event) {


        event.preventDefault();


        const selected = Array.from(newUserRoles.options)
            .filter(option => option.selected)
            .map(option => option.value.toString());

        const form = document.forms["newUser"];

        const data = {
            name:form.newUserName.value.trim() ,
            lastName: form.newUserLastName.value.trim(),
            age: form.newUserAge.value,
            email: form.newUserEmail.value.trim(),
            password:form.newUserPassword.value,
            roles: selected
        }



         function  createUser() {
           return  $.ajax({
                 type: 'POST',
                 headers: {'Content-Type': 'application/json'},
                 url: '/api/users',
                 data: JSON.stringify(data)
             });
         }

         $.when(createUser())
             .then( ()=>{
                 form.reset();
                 allUsers();
                 var someTabTriggerEl = document.querySelector('#nav-user-table-tab');
                 var tab = new bootstrap.Tab(someTabTriggerEl);
                 tab.show();

             })
    })

}

