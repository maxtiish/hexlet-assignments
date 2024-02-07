@import exercise.dto.users.UsersPage
@param UsersPage page

<form action = "/users" method="get">
    <input type ="search" name="term" value="$(page.getTerm))" />
    <input type="submit" value="Search">
</form>
@template.layout.page(
content = @`
    <h1>Пользователи</h1>
    @for(var user : page.getUsers())
        <div>
            <p>${user.getFirstName() + " " + user.getLastName()}</p>
            <p>${user.getEmail()}</p>
        </div>

    @endfor
`
)
