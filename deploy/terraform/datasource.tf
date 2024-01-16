data "aws_ami" "atelier_control_ami" {
  most_recent = true
  owners      = ["099720109477"]

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-jammy-22.04-amd64-server-20231207"]
  }
}


#preciso entender porque está sendp executado dentro do EC2 mas não consigo chamar de fora