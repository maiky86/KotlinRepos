# KotlinRepos
Simple app to introduce MVVM and androidx libraries. 

This app lists a set of gitHub repositories for which we can see some detail information.

The project is built on a step by step basis. The order of the branches is the following:
* starter_code -> Using a FakeRepository, mock data representing gitHub repositories is loaded.
* add_glide -> Integrate Glide library to handle the load of remote images and apply image transformations.
* add_viewmodel -> Add ViewModel and LiveData to handle bussiness logic
* add_repository -> Use Retrofit libraries to build a GitHub repository to retrieve information from GitHub servers.
* add_databinding -> Migrate layouts to use DataBinding
