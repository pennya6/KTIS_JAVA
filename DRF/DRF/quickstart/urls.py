from django.urls import include, path

from rest_framework import routers

from quickstart import views

# DRF Router config 
# -> DRF에는 viewset을 받아 url에 자동으로 매핑해주는 router라는 함수 존재
router = routers.DefaultRouter()
router.register(r'users', views.UserViewSet)
router.register(r'groups', views.GroupViewSet)
router.register(r'persons',views.PersonViewSet)

# Wire up our API using automatic URL routing.
# Additionally, we include login URLs for the browsable API.
urlpatterns = [
    path('', include(router.urls)), # add for API-ROOT test 
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]