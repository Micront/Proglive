SELECT users.username FROM users 
JOIN tweets 
ON tweets.login=users.login 
WHERE tweets.id=1;

SELECT message FROM tweets 
JOIN followers 
ON followers.user_to=tweets.login 
WHERE followers.user_from="aruizca";
