@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div>
        <main>
            <h1>Все посты</h1>

            <div>
                <a href="${NamedRoutes.buildPostPath()}">Создать новый пост</a>
            </div>
            <div>
                @for(var post : page.getPosts())
                            ${post.getId()}
                            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                            ${post.getBody()}
                @endfor
            </div>
        </main>
    </div>
`
)