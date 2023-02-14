$(async function() {
    await deleteUser()
});

async function deleteUser() {

    $('#getDelete').on('click', async function (event) {

        event.preventDefault();

        let urlDelete = '/api/users/' + idDelete.value;

        async function deleteUser() {
            return $.ajax({
                type: 'DELETE',
                headers: {'Content-Type': 'application/json'},
                url: urlDelete,


            });
        }

        $.when(deleteUser())
            .then(() => {
                allUsers();
                $('#closeDelete').click();
            })

    })
}

