#lab 8 Kevin Noonan
from urllib.request import urlopen
from html.parser import HTMLParser
#parser to handle html and strip out the random spaces
class ContentParser(HTMLParser):
    def __init__(self):
        HTMLParser.__init__(self)
        self.text = ''
    def handle_data(self,data):
	#print out the data on the site
        if len(data.strip()) != 0:
            self.text = data.strip()
            print(self.text)
    def getData(self):
        return self.text
    
def getContent(url):
    response = urlopen(url)
    html = response.read().decode()
    parser = ContentParser()
    parser.feed(html)
   
getContent('http://cdm.depaul.edu')
## class to grab the headers
class HeaderParser(HTMLParser):
    def __init__(self):
        HTMLParser.__init__(self)
        self.htag = False
        self.hlst = []
    def handle_starttag(self, tag, attrs):
        if tag in ['h1','h2','h3','h4','h5','h6']:
            self.htag = True
        else:
            self.htag = False
    def handle_data(self, data):
        if self.htag == True:
            self.hlst.append(data)
    def handle_endtag(self, tag):
        if tag in ['h1','h2','h3','h4','h5','h6']:
            self.htag = False
    def getHeaders(self):
        return self.hlst
            
##url = 'http://css.cdm.depaul.edu'
##response = urlopen(url)
##html = response.read().decode()
##parser = HeaderParser()
##parser.feed(html)
##print(parser.getHeaders())
