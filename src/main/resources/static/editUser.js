$('#editModal').on('show.bs.modal', event => {
    let button = $(event.relatedTarget);
    let id = button.data('id');
    showEditModal(id);
})

async function showEditModal(id) {
    $('#rolesEditUser').empty();
    let user = await getUser(id);
    let editUserForm = $('#formEditUser');
    editUserForm.find('#idEdit').value=user.id,
    editUserForm.find('#nameEdit').value=user.name,
    editUserForm.find('#lastnameEdit').value=user.lastName,
    editUserForm.find('#ageEdit').value=user.age,  
    editUserForm.find('#emailEdit').value=user.email,
    editUserForm.find('#passwordEdit').value=user.password,
    
    
    
    async function getUser(id) {
    let url = "/api/users/" + id;
    let response = await fetch(url);
    return await response.json();
}
    
 $(async function() {
    editUser();

});
function editUser() {
    
    editUserForm.addEventListener("submit", event => {
        event.preventDefault();
         let selected = Array.from(newUserRoles.options)
                .filter(option => option.selected)
                .map(option => option.value.toString());

       
        }

        fetch("http://localhost:8080/api/users/" + editForm.id.value, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
            id:addUserForm.find('#idEdit').val(),
            name:addUserForm.find('#nameEdit').val().trim(),
            lastName:addUserForm.find('#lastnameEdit').val().trim(),
            age:addUserForm.find('#ageEdit').val(),
            email:addUserForm.find('#emailEdit').val().trim(),
            password:addUserForm.find('#passwordEdit').val().trim(),
            roles:selected
            })
        }).then(() => {
            $('#editClose').click();
            allUsers();
        })
    })
}   
