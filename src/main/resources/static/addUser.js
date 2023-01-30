$(async function() {
    await createUser();
});
async function createUser() {
  
     let addUserForm = $('#newUser');

    addUserForm.addEventListener('submit', addNewUser)

    function addNewUser(e) {
        e.preventDefault();
          let selected = Array.from(newUserRoles.options)
                .filter(option => option.selected)
                .map(option => option.value.toString());

        
        fetch("/api/users", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
             name:addUserForm.find('#newUserName').val().trim(),
            lastName:addUserForm.find('#newUserLastName').val().trim(),
            age:addUserForm.find('#newUserAge').val(),
            email:addUserForm.find('#newUserEmail').val().trim(),
            password:addUserForm.find('#newUserPassword').val().trim(),
            roles:selected
            })
        }).then(() => {
            form.reset();
            allUsers();
            $('#nav-user-table-tab').click();
        })
    }

}

