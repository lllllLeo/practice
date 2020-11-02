from indeed import extract_indeed_pages, extract_indeed_jobs
import requests
from bs4 import BeautifulSoup
from save import save_to_file


last_indeed_page = extract_indeed_pages()

indeed_job = extract_indeed_jobs(last_indeed_page)

save_to_file(indeed_job)