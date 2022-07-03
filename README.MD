HATEOAS brings the same concepts to RESTful Web Services.

When some details of a resource are requested, you will provide the resource details as well as details of related resources and the possible actions you can perform on the resource. For example, when requesting information about a facebook user, a REST service can return the following

User details
Links to get his recent posts
Links to get his recent comments
Links to retrieve his friend’s list.

Entity extends RepresentationModel with links directly in Controller class

Refrences:
https://grapeup.com/blog/how-to-build-hypermedia-api-with-spring-hateoas/#