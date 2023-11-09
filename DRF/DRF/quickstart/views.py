from django.shortcuts import render
from rest_framework import viewsets
from rest_framework import permissions
from django.contrib.auth.models import User,Group

from quickstart.serializers import UserSerializer, GroupSerializer, PersonSerializer
from quickstart.models import Person

# Create your views here.
class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all().order_by('-date_joined')
    serializer_class = UserSerializer # serializer
    permission_classes = [permissions.IsAuthenticated]

class GroupViewSet(viewsets.ModelViewSet):
    queryset = Group.objects.all()
    serializer_class = GroupSerializer
    permission_classes = [permissions.IsAuthenticated]

class PersonViewSet(viewsets.ModelViewSet):
    queryset = Person.objects.all()
    serializer_class = PersonSerializer