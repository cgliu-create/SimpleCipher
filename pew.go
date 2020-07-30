package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
	"strconv"
)

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
func partionString(input string, size int) []string {
	var output []string
	for i := 0; i < len(input); {
		t := min(len(input), i+size)
		output = append(output, string(input[i:t]))
		i += size
	}
	return output
}
func reverseMap(input map[string]string) map[string]string {
	output := make(map[string]string)
	for key, value := range input {
		output[value] = key
	}
	return output
}

type cipher struct {
	ciphertable  map[string]string
	reversetable map[string]string
	cipherkey    string
}

func newCipher(key string) cipher {
	values := []string{
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
		"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
		"u", "v", "w", "x", "y", "z",
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
		"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
		"U", "V", "W", "X", "Y", "Z",
		"-Alpha#1-", "-Bravo#2-", "-Charlie#3-", "-Delta#4-", "-Echo#5-", "-Foxtrot#6-", "-Golf#7-", "-Hotel#8-", "-India#9-",
		"-Juliett#10-", "-Kilo#11-", "-Lima#12-", "-Mike#13-", "-November#14-", "-Oscar#15-", "-Papa#16-", "-Quebec#17", "-Romeo#18-",
		"-Sierra#19-", "-Tango#20-", "-Uniform#21-", "-Victor#22-", "-Whiskey#23-", "-Xray#24-", "-Yankee#25-", "-Zulu#26-",
		"-One#1-", "-Two#2-", "-Three#3-", "-Four#4-", "-Five#5-", "-Six#6-", "-Seven#7-", "-Eight#8-", "-Nine#9-", "-Ten#10-",
		"-Chris-", "-Liu-",
	}
	table := map[string]string{}
	for i := 0; i < len(values); i++ {
		codon := "##"
		if i < 10 {
			codon = "0" + strconv.Itoa(i)
		} else {
			codon = strconv.Itoa(i/10) + strconv.Itoa(i%10)
		}
		table[codon] = values[i]
	}
	reverse := reverseMap(table)
	return cipher{ciphertable: table, cipherkey: key, reversetable: reverse}
}
func (c cipher) chartoNum(input string) string {
	var output string
	inputChar := partionString(input, 1)
	readtag := false
	var inputCodons []string
	var working []string
	for i := 0; i < len(inputChar); i++ {
		if inputChar[i] == "-" {
			readtag = !readtag
		}
		if readtag {
			working = append(working, inputChar[i])
		}
		if !readtag && len(working) > 0 {
			working = append(working, inputChar[i])
			codon := ""
			for _, val := range working {
				codon += val
			}
			inputCodons = append(inputCodons, codon)
			working = make([]string, 0)
		}
		if !readtag && len(working) == 0 {
			inputCodons = append(inputCodons, inputChar[i])
		}
	}
	table := c.reversetable
	for i := 0; i < len(inputCodons); i++ {
		codon := inputCodons[i]
		output += table[codon]
	}
	return output
}
func (c cipher) numtoChar(input string) string {
	var output string
	inputCodons := partionString(input, 2)
	table := c.ciphertable
	for i := 0; i < len(inputCodons); i++ {
		codon := inputCodons[i]
		output += table[codon]
	}
	return output
}
func (c cipher) numtoBinary(inputNum string) string {
	n := new(big.Int)
	n, ok := n.SetString(inputNum, 10)
	if !ok {
		fmt.Println("SetString: error num to binary")
	}
	return n.Text(2)
}
func (c cipher) binarytoNum(inputBinary string) string {
	n := new(big.Int)
	n, ok := n.SetString(inputBinary, 2)
	if !ok {
		fmt.Println("SetString: error binary to num")
	}
	return n.Text(10)
}
func (c cipher) makeBinaryKey(length int) string {
	key := c.cipherkey
	keyCode := c.chartoNum(key)
	keyBit := c.numtoBinary(keyCode)
	output := ""
	for len(output) < length {
		output += keyBit
	}
	output = string(output[0:length])
	return output
}
func (c cipher) xor(a, b string) string {
	// a and b equals 0 or 1
	if a == b {
		return "0"
	}
	return "1"
}
func (c cipher) xorComparison(binarymsg string) string {
	key := c.makeBinaryKey(len(binarymsg))
	keybits := partionString(key, 1)
	msgbits := partionString(binarymsg, 1)
	output := ""
	for i := 0; i < len(msgbits); i++ {
		mbit := msgbits[i]
		kbit := keybits[i]
		rbit := c.xor(mbit, kbit)
		output += rbit
	}
	return output
}

func (c cipher) cipherIt(msg string) string {
	num := c.chartoNum(msg)
	bits := c.numtoBinary(num)
	cbits := c.xorComparison(bits)
	ccbits := "1" + cbits
	cnum := c.binarytoNum(ccbits)
	out := c.numtoChar(cnum)
	return out
}

func (c cipher) uncipherIt(msg string) string {
	num := c.chartoNum(msg)
	bits := c.numtoBinary(num)
	cbits := string(bits[1:])
	ccbits := c.xorComparison(cbits)
	cnum := c.binarytoNum(ccbits)
	out := c.numtoChar(cnum)
	return out
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	response := ""
	// K:
	// P:
	// R:
	for {
		fmt.Println("Enter K")
		scanner.Scan()
		response = scanner.Text()
		c := newCipher(response)

		fmt.Println("Enter P")
		scanner.Scan()
		response = scanner.Text()
		ctxt := c.cipherIt(response)

		fmt.Println("Here is R")
		fmt.Println(ctxt)

		fmt.Println("Continue? y/n")
		scanner.Scan()
		response = scanner.Text()
		if response == "no" || response == "n" {
			os.Exit(0)
		}
	}
	// txt := c.uncipherIt(ctxt)
	// fmt.Println(txt)
}
