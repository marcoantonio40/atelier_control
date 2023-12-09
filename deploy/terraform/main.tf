resource "aws_vpc" "atelier_control_vpc" {
  cidr_block = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support = true

  tags = {
    Name = "atelier_control_vpc"
  }
}

resource "aws_subnet" "atelier_control_subnet" {
  vpc_id = aws_vpc.atelier_control_vpc.id
  cidr_block = "10.0.1.0/24"
  availability_zone = "us-east-2a"

  tags = {
    Name = "atelier_control_subnet_pub"
  }
}