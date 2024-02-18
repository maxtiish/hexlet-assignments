@import exercise.dto.posts.EditPostPage
@param EditPostPage page

@template.layout.page(
    content = @`
    @if (page.getErrors() != null)
        @for (var validator : page.getErrors().values())
            @for (var error : validator)
                ${error.getMessage()}
            @endfor
        @endfor
    @endif

    <div>
    <form action="/posts" method="post">
    <div>
        <label>
            Название
            <input type="text" class="form-control" name="name" value="${page.getName()}" />
        </label>
    </div>
        <div>
        <label>Содержание</label>
            <textarea rows="20" cols="70" type="text" name="body">${page.getBody()}</textarea>
        </div>
        <input type="submit" class="btn btn-primary" value="Сохранить" />
    </form>
    </div>

`
)
