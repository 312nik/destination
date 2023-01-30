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
