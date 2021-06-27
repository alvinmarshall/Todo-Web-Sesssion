# so first this is going to call
# the yaml file and spin up a container
# so i'm going to run this in the terminal
# when u have a Makefile, all u have to do this
# declare the commands and just call this commands with the tag
# eg of a tag is the start or the stop

start:
	docker-compose up -d

# stop the container and release resources
stop:
	docker-compose down