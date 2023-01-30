$('#deleteModal').on('show.bs.modal', event => {
    let button = $(event.relatedTarget);
    let id = button.data('id');
    showEditModal(id);
})

async function showEditModal(id) {
  
    let user = await getUser(id);
    let deleteUserForm = $('#formDeleteUser');
    editUserForm.find('#idDelete').value=user.id,
    editUserForm.find('#nameDelete').value=user.name,
    editUserForm.find('#lastnameDelete').value=user.lastName,
    editUserForm.find('#ageDelete').value=user.age,  
    editUserForm.find('#emailDelete').value=user.email,
    editUserForm.find('#passwordDelete').value=user.password,
    
    
    
    async function getUser(id) {
    let url = "/api/users/" + id;
    let response = await fetch(url);
    return await response.json();
}
    
    
$(async function() {
    deleteUser();

});
function deleteUser() {
    
    deleteUserForm.addEventListener("submit", event => {
        event.preventDefault();
        
         let selected = Array.from(newUserRoles.options)
                .filter(option => option.selected)
                .map(option => option.value.toString());

       
        }

        fetch("/api/users/" + deleteUserForm.find('#idDelete').value, {
            method: 'Delete',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
            id:addUserForm.find('#idDelete').val(),
            name:addUserForm.find('#nameDelete').val().trim(),
            lastName:addUserForm.find('#lastnameDelete').val().trim(),
            age:addUserForm.find('#ageDelete').val(),
            email:addUserForm.find('#emailDelete').val().trim(),
            password:addUserForm.find('#passwordDelete').val().trim(),
            roles:selected
            })
        }).then(() => {
            $('#editClose').click();
            allUsers();
        })
    })
}   
