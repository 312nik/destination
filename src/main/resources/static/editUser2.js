$(async function() {
    await editUser()
});

async function editUser() {

    $('#getEdit').on('click', async function (event) {

        event.preventDefault();

        let urlEdit = '/api/users/' + idEdit.value;

        const selected = Array.from(rolesEdit.options)
            .filter(option => option.selected)
            .map(option => option.value.toString());


        const dataEdit = {
            id:formEdit.idEdit.value,
            name: formEdit.nameEdit.value.trim(),
            lastName: formEdit.lastnameEdit.value.trim(),
            age: formEdit.ageEdit.value,
            email: formEdit.emailEdit.value.trim(),
            password: formEdit.passwordEdit.value.trim(),
            roles: selected
        }

        async function updateUser() {
            return $.ajax({
                type: 'PATCH',
                headers: {'Content-Type': 'application/json'},
                url: urlEdit,
                data: JSON.stringify(dataEdit),

            });
        }


        $.when(updateUser())
            .then(() => {
               allUsers();
               $('#closeEdit').click();
            })




    })
}