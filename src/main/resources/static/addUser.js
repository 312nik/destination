

$("#addNewUser").click(
    async () =>  {
        let addUserForm = $('#newUser');

        let Roles = [];
        for (let i = 0; i < newUserRoles.length; i++) {
            alert(newUserRoles[i].value);
            alert(newUserRoles[i].options)
        }


           /* let selected = Array.from(newUserRoles.options)
                .filter(option => option.selected)
                .map(option => option.value);*/

       /* alert(addUserForm.find('#newUserName').val().trim())
        alert(addUserForm.find('#newUserLastName').val().trim())
        alert(addUserForm.find('#newUserAge').val().trim())
        alert(addUserForm.find('#newUserEmail').val().trim())
        alert(addUserForm.find('#newUserPassword').val().trim())
        alert(selected)*/



        let data = {
            name:addUserForm.find('#newUserName').val().trim(),
            lastName:addUserForm.find('#newUserLastName').val().trim(),
            age:addUserForm.find('#newUserAge').val().trim(),
            email:addUserForm.find('#newUserEmail').val().trim(),
            password:addUserForm.find('#newUserPassword').val().trim(),
            roles:listOfRole
        }

      let method = {
                    method: 'POST',
                    headers: {
                            'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
            }


            await fetch("/api/users", method).then(() => {

            });


});