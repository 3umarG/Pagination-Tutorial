data class PaginatedResponseDto<T>(
    val currentPage: Int,
    val totalPages: Int,
    val items: List<T>
)
