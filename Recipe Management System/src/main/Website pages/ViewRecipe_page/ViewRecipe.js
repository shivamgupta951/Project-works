// JavaScript to handle the bookmark functionality
function toggleBookmark() {
    const bookmarkButton = document.getElementById('bookmark-btn');
    
    if (bookmarkButton.classList.contains('bookmarked')) {
        // If already bookmarked, remove the bookmark
        bookmarkButton.classList.remove('bookmarked');
        bookmarkButton.innerText = 'Bookmark Recipe';
    } else {
        // If not bookmarked, add the bookmark
        bookmarkButton.classList.add('bookmarked');
        bookmarkButton.innerText = 'Recipe Bookmarked';
    }
}
