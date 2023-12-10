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

resource "aws_internet_gateway" "atelier_control_internet_gateway" {
  vpc_id = aws_vpc.atelier_control_vpc.id

  tags = {
    Name = "atelier_control_internet_gateway"
  }
}

resource "aws_route_table" "atelier_control_route_table" {
  vpc_id = aws_vpc.atelier_control_vpc.id

  tags = {
    Name = "atelier_control_route_table"
  }
}

resource "aws_route" "atelier_control_route" {
  route_table_id = aws_route_table.atelier_control_route_table.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id = aws_internet_gateway.atelier_control_internet_gateway.id

  tags = {
    Name = "atelier_control_route"
  }
}

resource "aws_route_table_association" "atelier_control_route_table_association" {
  route_table_id = aws_route_table.atelier_control_route_table.id
  subnet_id = aws_subnet.atelier_control_subnet.id

  tags = {
    Name = "atelier_control_route_table_association"
  }
}