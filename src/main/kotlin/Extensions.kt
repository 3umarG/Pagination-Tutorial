import org.springframework.data.domain.Page

fun <T> Page<T>.toPaginatedResponseDto(): PaginatedResponseDto<T> {
    val currentPage = if (this.totalPages == 0) 0 else this.number + 1
    val items = this.content
    val totalPages = this.totalPages

    return PaginatedResponseDto(currentPage, totalPages, items)
}


fun <T, R> Page<T>.toPaginatedResponseDto(transform: (T) -> R): PaginatedResponseDto<R> {
    val currentPage = if (this.totalPages == 0) 0 else this.number + 1
    val items = this.content.map(transform)
    val totalPages = this.totalPages

    return PaginatedResponseDto(currentPage, totalPages, items)
}
