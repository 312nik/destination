$('#editModal').on('show.bs.modal', event => {
    let button = $(event.relatedTarget);
    let id = button.data('id');
    showEditModal(id);
})

async function showEditModal(id) {
    $('#rolesEditUser').empty();
    let user = await getUser(id);
    let editUserForm = $('#formEditUser');
    editUserForm.find('#id').value=user.id,
    editUserForm.find('#name').value=user.name,
    editUserForm.find('#lastName').value=user.lastName,
    editUserForm.find('#age').value=user.age,  
    editUserForm.find('#email').value=user.email,
    editUserForm.find('#password').value=user.password,
    
    
    
    async function getUser(id) {
    let url = "/api/users/" + id;
    let response = await fetch(url);
    return await response.json();
}
